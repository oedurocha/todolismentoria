package Api.todolist.todolistmentoria.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Setter
@Getter
@ToString

public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    @NotBlank(message = "Campo NOME DO CLIENTE, não deve ser Em branco")
    private String nomeDoCliente;

    @Column(nullable = false)
    @NotBlank(message = "Campo NOME DA TAREFA, não deve ser Em branco")
    private String nomeDaTarefa;

    @Column(nullable = false)
    @NotBlank(message = "Campo DESCRIÇÃO DA TAREFA, não deve ser Em branco")
    private String descricaoDaTarefa;

    @Column(nullable = false)
    @NotNull(message = "Campo DATA DA CONCLUSÃO, não deve ser Em branco")
    private LocalDateTime dataDaConclusao;

    @Column(nullable = false)
    @NotBlank(message = "Campo STATUS, não deve ser Em branco")
    private String status;

    @Column(nullable = false)
    @NotBlank(message = "Campo RESPONSAVEL PELA TAREFA, não deve ser Em branco")
    private String responsavelPelaTarefa;

    @Column(nullable = false)
    @NotBlank(message = "Campo SOLICITANTE, não deve ser Em branco")
    private String solicitante;

    @CreationTimestamp
    @Column(name = "data_Da_Criacao", nullable = false, updatable = false)
    private LocalDateTime dataDaCriacao;

    @UpdateTimestamp
    @Column(name = "atualizado_Em")
    private  LocalDateTime atualizadoEm;

    }


