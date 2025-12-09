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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
import lombok.Data;

/*
 * Ana Caroline Pedrosa e Silva
 * ATV02 - Bean Validation
 */

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate birthDate;

    @NotBlank(message = "O nome é obrigatório.")
    @Min(value = 3, message = "O nome deve ter no minimo 3 caracteres")
    @Max(value = 50, message= "O nome deve ter no maximo 50 caracteres")
    String name;


    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O formato de email inválido.")
    String email;     
    

    @NotBlank(message = "O CPF é obrigatório.")
    @CPF
    String cpf;

    @NotBlank
    @PlacaValida
    String placa;

    @Impar
    Integer numero;

    @NotBlank
    @CNHValida
    String cnh;

    @NotBlank

    @AnoFabricacaoValido
    String anoCarro;

    @NotBlank
    @SemPalavrasOfensivas
    String comebirthDatentario;

}
