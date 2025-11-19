package br.com.ifba.prg03spring;

import br.com.ifba.curso.view.CursoListar;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.ifba.curso.repository")
@EntityScan(basePackages = "br.com.ifba.curso.entity")
@ComponentScan(basePackages = "br.com.ifba")
public class Prg03springApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Prg03springApplication.class)
            .headless(false)
            .run(args);
    }

    @Bean
    public ApplicationRunner init(CursoListar telaListar) {
    return args -> {
        javax.swing.SwingUtilities.invokeLater(() -> {
            telaListar.carregarCursos();
            telaListar.setVisible(true);
            
        });
    };
}


}