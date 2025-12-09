package br.edu.ifpr.demo.domain;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import br.edu.ifpr.demo.validate.AnoFabricacaoValido;
import br.edu.ifpr.demo.validate.CNHValida;
import br.edu.ifpr.demo.validate.Impar;
import br.edu.ifpr.demo.validate.PlacaValida;
import br.edu.ifpr.demo.validate.SemPalavrasOfensivas;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Nome não pode estar em branco")
    String name;

    @NotNull(message = "Data de nascimento não pode ser nula")
    LocalDate birthDate;

    @NotBlank(message = "Email não pode estar em branco")
    @Email(message = "Email inválido")
    String email;     

    @NotBlank(message = "CPF não pode estar em branco")
    @CPF(message = "CPF inválido")
    String cpf;

    @NotBlank(message = "Placa não pode estar em branco")
    @PlacaValida
    String placa;

    @NotNull(message = "Número não pode ser nulo")
    @Impar
    Integer numero;

    @NotBlank(message = "CNH não pode estar em branco")
    @CNHValida
    String cnh;

    @NotNull(message = "Ano do carro não pode ser nulo")
    @AnoFabricacaoValido
    Integer anoCarro;

    @NotBlank(message = "Comentário não pode estar em branco")
    @SemPalavrasOfensivas
    String comentario;
}