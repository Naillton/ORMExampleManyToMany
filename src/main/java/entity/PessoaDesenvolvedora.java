package entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pessoa_desenvolvedora")
public class PessoaDesenvolvedora {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;

  private String linguagens;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "relacionamento_pessoadesenvolvedora_projeto",
          joinColumns = {@JoinColumn(name = "pessoa_desenvolvedora_id")},
          inverseJoinColumns = {@JoinColumn(name = "projeto_id")})
  private List<Projeto> projetos = new ArrayList<>();

  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getLinguagens() {
    return linguagens;
  }

  public void setLinguagens(String linguagens) {
    this.linguagens = linguagens;
  }

  public List<Projeto> getProjetos() {
    return projetos;
  }

  public void setProjetos(List<Projeto> projetos) {
    this.projetos = projetos;
  }

  public void addProjeto(Projeto projeto) {
    this.projetos.add(projeto);
  }
}
