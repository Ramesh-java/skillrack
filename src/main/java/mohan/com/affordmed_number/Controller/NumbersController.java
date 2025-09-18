package mohan.com.affordmed_number.Controller;

import mohan.com.affordmed_number.Model.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("/base")
public class NumbersController {

    private final WebClient webClient = WebClient.create();

    @GetMapping(value = "/numbers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> getNumbers(@RequestParam List<String> url) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(url.size());

        List<CompletableFuture<List<Integer>>> futures = url.stream()
                .map(u -> CompletableFuture.supplyAsync(() -> fetchNumbers(u), executor))
                .collect(Collectors.toList());

        List<Integer> mergedNumbers = futures.stream()
                .map(future -> {
                    try {
                        return future.get(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        return Collections.<Integer>emptyList();
                    }
                })
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .toList();

        executor.shutdown();
        System.out.println(mergedNumbers);

        return Collections.singletonMap("numbers", mergedNumbers);
    }

    private List<Integer> fetchNumbers(String url) {
        try {
            // validate URL
            new URI(url);

            NumbersResponse response = webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(NumbersResponse.class)
                    //.timeout(Duration.ofMillis(500))     // per-request timeout
                    .onErrorResume(e -> Mono.empty())    // ignore error/timeout
                    .block();

            if (response != null && response.getNumbers() != null) {
                return response.getNumbers();
            }

        } catch (URISyntaxException e) {
            // invalid URL
        } catch (Exception e) {
            // ignore other errors
        }
        return Collections.emptyList();
    }

//    @GetMapping("/primes")
//    public List<Integer>  getPrimes() {
//        List<Integer> primes = List.of(1,2,3,5,7,9,11,13,17,19);
//        return primes;
//
//    }
//    @GetMapping("/odd")
//    public List<Integer>  getOddNumbers() {
//        List<Integer> oddNumbers = List.of(1,3,5,7,9,11,13,15,17,19);
//        return oddNumbers;
//    }
//
//    @GetMapping("/fibo")
//    public List<Integer>  getFiboNumbers() {
//        List<Integer> fiboNumbers = List.of(1,2,3,5,8);
//        return fiboNumbers;
//    }

    @GetMapping("/primes")
    public Map<String, Object> getPrimes() {
        return Map.of("numbers", List.of(1,2,3,5,7,9,11,13,17,19));
    }

    @GetMapping("/odd")
    public Map<String, Object> getOddNumbers() {
        return Map.of("numbers", List.of(1,3,5,7,9,11,13,15,17,19));
    }

    @GetMapping("/fibo")
    public Map<String, Object> getFiboNumbers() {
        return Map.of("numbers", List.of(1,2,3,5,8));
    }




}
