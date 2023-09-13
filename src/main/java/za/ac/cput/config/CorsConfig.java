package za.ac.cput.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from specific origins (e.g., your Vue.js frontend)
        config.addAllowedOrigin("http://localhost:8081"); // Replace with your frontend URL
        config.addAllowedMethod("*"); // Allow all HTTP methods (GET, POST, etc.)
        config.addAllowedHeader("*"); // Allow all headers

        // You can add more specific CORS rules here if needed

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
