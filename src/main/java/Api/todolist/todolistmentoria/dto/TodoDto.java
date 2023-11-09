package Api.todolist.todolistmentoria.dto;

import Api.todolist.todolistmentoria.model.Status;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Setter
@Getter
@ToString

public class TodoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    @NotBlank(message = "Campo NOME DO CLIENTE, não deve ser nulo")
    private String nomeDoCliente;

    @Column(nullable = false)
    @NotBlank(message = "Campo NOME DA TAREFA, não deve ser nulo")
    private String nomeDaTarefa;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime concluidoEm;


    @Column(nullable = false)
    @NotBlank(message = "Campo DESCRIÇÃO DA TAREFA, não deve ser nulo")
    private String descricaoDaTarefa;

    @Column(nullable = false)
    @NotNull(message = "Campo DATA DA CONCLUSÃO, não deve ser nulo")
    private LocalDateTime dataDaConclusao;

    @Column(nullable = false)
    @NotNull(message = "Campo STATUS, não deve ser nulo")
    private Status status;

    @Column(nullable = false)
    @NotBlank(message = "Campo RESPONSAVEL PELA TAREFA, não deve ser nulo")
    private String responsavelPelaTarefa;

    @Column(nullable = false)
    @NotBlank(message = "Campo SOLICITANTE, não deve ser nulo")
    private String solicitante;

    @CreationTimestamp
    @Column(name = "data_Da_Criacao", nullable = false, updatable = false)
    private LocalDateTime dataDaCriacao;

    @UpdateTimestamp
    @Column(name = "atualizado_Em")
    private  LocalDateTime atualizadoEm;


    }


