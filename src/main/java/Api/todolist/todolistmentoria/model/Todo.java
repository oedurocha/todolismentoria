package Api.todolist.todolistmentoria.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    private String nomeDoTarefa;

    @Column(nullable = false)
    private String descricaoDaTarefa;

    @Column(nullable = false)
    private LocalDateTime dataDaConclusao;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String responsavelPelaTarefa;

    @Column(nullable = false)
    private String solicitante;

    @CreationTimestamp
    @Column(name = "data_Da_Criacao", nullable = false, updatable = false)
    private LocalDateTime dataDaCriacao;

    @UpdateTimestamp
    @Column(name = "atualizado_Em")
    private  LocalDateTime atualizadoEm;

}


