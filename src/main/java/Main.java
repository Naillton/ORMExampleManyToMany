import entity.PessoaDesenvolvedora;
import entity.PessoaDesenvolvedoraService;
import entity.Projeto;
import entity.ProjetoService;

public class Main {
  public static void main(String[] args) {
    PessoaDesenvolvedoraService pService = new PessoaDesenvolvedoraService();
    ProjetoService projetoService = new ProjetoService();

    Projeto projeto1 = new Projeto();
    projeto1.setNome("App de receitas");
    projeto1.setTecnologia("Kotlin");
    projetoService.save(projeto1);

    Projeto projeto2 = new Projeto();
    projeto2.setNome("Site Barbearia");
    projeto2.setTecnologia("Javascript");
    projetoService.save(projeto2);

    Projeto projeto3 = new Projeto();
    projeto3.setNome("RH BackEnd");
    projeto3.setTecnologia("Java");
    projetoService.save(projeto3);

    PessoaDesenvolvedora dev1 = new PessoaDesenvolvedora();
    dev1.setNome("Dev 1");
    dev1.setLinguagens("Kotlin, Java");
    pService.save(dev1);

    dev1.addProjeto(projeto1);
    dev1.addProjeto(projeto2);
    pService.update(dev1);

    // deletando pessoa desenvolvedora
    // pService.delete(dev1);
    PessoaDesenvolvedora dev2 = new PessoaDesenvolvedora();
    dev2.setNome("Dev 2");
    dev2.setLinguagens("JavaScript, Java");
    pService.save(dev2);

    dev2.addProjeto(projeto2);
    dev2.addProjeto(projeto3);
    dev2.setNome("Developer 2");
    pService.update(dev2);

    pService.updateUsandoHQL(1L, "Developer Kotlin 1");
    pService.listaUsandoHQL().forEach(it -> {
      System.out.println(it.getNome());
    });
  }
}
