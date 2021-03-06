package br.com.utfpr.testes.aluno;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecuperaSituacaoAlunoTest {

	public RecuperaSituacaoAlunoTest() {
		baseURI = "http://localhost:8080/utfpr-notas/rest/notas";
	}

	@Test
	public void isServicoAtivo() {
		given().when().get("/servico-ativo").then().statusCode(200);
	}

	@Test
	public void testConsultaAlunoAprovado() {
		Map<String, Object> aluno = new HashMap<String, Object>();
		Map<String, Object> notaPrimeiroBimestre = new HashMap<String, Object>();
		Map<String, Object> notaSegundoBimestre = new HashMap<String, Object>();
		Map<String, Object> notaTerceiroBimestre = new HashMap<String, Object>();
		Map<String, Object> notaQuartoBimestre = new HashMap<String, Object>();

		notaPrimeiroBimestre.put("nota", 7.5);
		notaPrimeiroBimestre.put("observacaoNota", "Nota primeiro bimestre");

		notaSegundoBimestre.put("nota", 9.5);
		notaSegundoBimestre.put("observacaoNota", "Nota segundo bimestre");

		notaTerceiroBimestre.put("nota", 10.0);
		notaTerceiroBimestre.put("observacaoNota", "Nota terceiro bimestre");

		notaQuartoBimestre.put("nota", 8.0);
		notaQuartoBimestre.put("observacaoNota", "Nota quarto bimestre");

		ArrayList<Object> notas = new ArrayList<Object>();
		notas.add(notaPrimeiroBimestre);
		notas.add(notaSegundoBimestre);
		notas.add(notaTerceiroBimestre);
		notas.add(notaQuartoBimestre);

		aluno.put("id", "2");
		aluno.put("nome", "Liliane Caroline");
		aluno.put("realizouExame", "0");
		aluno.put("notas", notas);

		given().contentType("application/json").body(aluno).when().post("/cadastra-aluno").then()
				.body("situacao", equalTo("APROVADO")).assertThat();
	}

	@Test
	public void testConsultaAlunoExame() {
		Map<String, Object> aluno = new HashMap<String, Object>();
		Map<String, Object> notaPrimeiroBimestre = new HashMap<String, Object>();
		Map<String, Object> notaSegundoBimestre = new HashMap<String, Object>();
		Map<String, Object> notaTerceiroBimestre = new HashMap<String, Object>();
		Map<String, Object> notaQuartoBimestre = new HashMap<String, Object>();

		notaPrimeiroBimestre.put("nota", 5.5);
		notaPrimeiroBimestre.put("observacaoNota", "Nota primeiro bimestre");

		notaSegundoBimestre.put("nota", 4.5);
		notaSegundoBimestre.put("observacaoNota", "Nota segundo bimestre");

		notaTerceiroBimestre.put("nota", 6.0);
		notaTerceiroBimestre.put("observacaoNota", "Nota terceiro bimestre");

		notaQuartoBimestre.put("nota", 8.0);
		notaQuartoBimestre.put("observacaoNota", "Nota quarto bimestre");

		ArrayList<Object> notas = new ArrayList<Object>();
		notas.add(notaPrimeiroBimestre);
		notas.add(notaSegundoBimestre);
		notas.add(notaTerceiroBimestre);
		notas.add(notaQuartoBimestre);

		aluno.put("id", "3");
		aluno.put("nome", "Renato Pradebon");
		aluno.put("realizouExame", "0");
		aluno.put("notas", notas);

		given().contentType("application/json").body(aluno).when().post("/cadastra-aluno").then()
				.body("situacao", equalTo("EXAME")).assertThat();
	}

	@Test
	public void testConsultaAlunoReprovadoExame() {
		Map<String, Object> aluno = new HashMap<String, Object>();
		Map<String, Object> notaPrimeiroBimestre = new HashMap<String, Object>();
		Map<String, Object> notaSegundoBimestre = new HashMap<String, Object>();
		Map<String, Object> notaTerceiroBimestre = new HashMap<String, Object>();
		Map<String, Object> notaQuartoBimestre = new HashMap<String, Object>();

		notaPrimeiroBimestre.put("nota", 6.5);
		notaPrimeiroBimestre.put("observacaoNota", "Nota primeiro bimestre");

		notaSegundoBimestre.put("nota", 2.0);
		notaSegundoBimestre.put("observacaoNota", "Nota segundo bimestre");

		notaTerceiroBimestre.put("nota", 4.0);
		notaTerceiroBimestre.put("observacaoNota", "Nota terceiro bimestre");

		notaQuartoBimestre.put("nota", 7.5);
		notaQuartoBimestre.put("observacaoNota", "Nota quarto bimestre");

		notaQuartoBimestre.put("nota", 6.0);
		notaQuartoBimestre.put("observacaoNota", "Nota exame");

		ArrayList<Object> notas = new ArrayList<Object>();
		notas.add(notaPrimeiroBimestre);
		notas.add(notaSegundoBimestre);
		notas.add(notaTerceiroBimestre);
		notas.add(notaQuartoBimestre);

		aluno.put("id", "4");
		aluno.put("nome", "Hicaro Juan");
		aluno.put("realizouExame", "1");
		aluno.put("notas", notas);

		given().contentType("application/json").body(aluno).when().post("/cadastra-aluno").then()
				.body("situacao", equalTo("REPROVADO")).assertThat();
	}

	@Test
	public void testConsultaAlunoAprovadoExame() {
		Map<String, Object> aluno = new HashMap<String, Object>();
		Map<String, Object> notaPrimeiroBimestre = new HashMap<String, Object>();
		Map<String, Object> notaSegundoBimestre = new HashMap<String, Object>();
		Map<String, Object> notaTerceiroBimestre = new HashMap<String, Object>();
		Map<String, Object> notaQuartoBimestre = new HashMap<String, Object>();
		Map<String, Object> notaExame = new HashMap<String, Object>();

		notaPrimeiroBimestre.put("nota", 3.5);
		notaPrimeiroBimestre.put("observacaoNota", "Nota primeiro bimestre");

		notaSegundoBimestre.put("nota", 5.0);
		notaSegundoBimestre.put("observacaoNota", "Nota segundo bimestre");

		notaTerceiroBimestre.put("nota", 8.0);
		notaTerceiroBimestre.put("observacaoNota", "Nota terceiro bimestre");

		notaQuartoBimestre.put("nota", 9.5);
		notaQuartoBimestre.put("observacaoNota", "Nota quarto bimestre");

		notaExame.put("nota", 9.0);
		notaExame.put("observacaoNota", "Nota exame");

		ArrayList<Object> notas = new ArrayList<Object>();
		notas.add(notaPrimeiroBimestre);
		notas.add(notaSegundoBimestre);
		notas.add(notaTerceiroBimestre);
		notas.add(notaQuartoBimestre);
		notas.add(notaExame);

		aluno.put("id", "5");
		aluno.put("nome", "Joni Nunes");
		aluno.put("realizouExame", "1");
		aluno.put("notas", notas);

		given().contentType("application/json").body(aluno).when().post("/cadastra-aluno").then()
				.body("situacao", equalTo("APROVADO")).assertThat();
	}

	@Test
	public void testEditaAlunoExame() {

		Map<String, Object> aluno = new HashMap<String, Object>();
		Map<String, Object> notaExameFinal = new HashMap<String, Object>();

		notaExameFinal.put("nota", 10.0);
		notaExameFinal.put("observacaoNota", "Nota exame final");

		ArrayList<Object> notas = new ArrayList<Object>();
		notas.add(notaExameFinal);

		aluno.put("id", "3");
		aluno.put("nome", "Renato Pradebon");
		aluno.put("realizouExame", "0");
		aluno.put("notas", notas);

		given().contentType("application/json").body(aluno).when().put("/edita-aluno").then()
				.body("situacao", equalTo("EXAME")).assertThat();

	}

	@Test
	public void testDeleteAluno() {
		given().contentType("application/json").pathParam("idAluno", 5).when().delete("/deleta-aluno/{idAluno}").then()
				.body("status", equalTo("REMOVED")).statusCode(200);
	}

	@Test
	public void testRetornoAluno() {
		given().contentType("application/json").when().pathParam("idAluno", 2).get("/aluno/{idAluno}").then()
				.body("nome", equalTo("Liliane Caroline")).body("situacao", equalTo("APROVADO")).statusCode(200);
	}
}
