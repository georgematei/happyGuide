package hg;

/**
 * Created by Andreea on 25.11.2016.
 */
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(AccountRepository accountRepository,
                           BookmarkRepository bookmarkRepository,
                           UserRepository userRepository) {


        User user = userRepository.save(new User ("maria", "passpwrd"));
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(user.getId());

        return (evt) -> Arrays.asList(
                "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                .forEach(
                        a -> {
                            Account account = accountRepository.save(new Account(a,
                                    "password"));
                            bookmarkRepository.save(new Bookmark(account,
                                    "http://bookmark.com/1/" + a, "A description"));
                            bookmarkRepository.save(new Bookmark(account,
                                    "http://bookmark.com/2/" + a, "A description"));
                        });
    }

}