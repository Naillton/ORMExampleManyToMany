package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_projeto")
public class Projeto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;

  private String tecnologia;

  @ManyToMany(mappedBy = "projetos", cascade = CascadeType.ALL)
  private List<PessoaDesenvolvedora> pessoaDesenvolvedoras;

  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTecnologia() {
    return tecnologia;
  }

  public void setTecnologia(String tecnologia) {
    this.tecnologia = tecnologia;
  }

  public List<PessoaDesenvolvedora> getPessoaDesenvolvedoras() {
    return pessoaDesenvolvedoras;
  }

  public void setPessoaDesenvolvedoras(List<PessoaDesenvolvedora> pessoaDesenvolvedoras) {
    this.pessoaDesenvolvedoras = pessoaDesenvolvedoras;
  }

  public void addPessoaDesenvolvedoras(PessoaDesenvolvedora pessoaDesenvolvedora) {
    this.pessoaDesenvolvedoras.add(pessoaDesenvolvedora);
  }
}
