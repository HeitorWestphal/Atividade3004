package dao;

import java.util.ArrayList;
import model.Aluno;

public class AlunoDAO {

    private final ArrayList<Aluno> database = new ArrayList();

    public void addDatabase(Aluno aluno) {
        database.add(aluno);
    }

    public void listarAluno(int id) {
        boolean alunoFound = false;
        for (Aluno aluno : database) {
            if (aluno.getId() == id) {
                alunoFound = true;
                System.out.println("ID: " + aluno.getId());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Idade: " + aluno.getIdade());
                System.out.println("Curso: " + aluno.getCurso());
                System.out.println("Fase: " + aluno.getFase());
                System.out.println("-------------------\n");
            }
        }

        if (!alunoFound) {
            throw new Error("Aluno não encontrado com o ID: " + id);
        }
    }

    public void listarTodosAlunos() {
        if (database.isEmpty()) {
            throw new Error("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : database) {
                System.out.println(aluno.toString());
                System.out.println("-------------------\n");
            }
        }
    }

    public void editarAluno(int id, Aluno novoAluno) {
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getId() == id) {
                database.set(i, novoAluno);
                System.out.println("Aluno editado com sucesso.");
                return;
            }
        }
        throw new Error("Aluno não encontrado com o ID: " + id);
    }

    public void excluirAluno(int id) {
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getId() == id) {
                database.remove(i);
                System.out.println("Aluno excluído com sucesso.");
                return;
            }
        }
        throw new Error("Aluno não encontrado com o ID: " + id);
    }
}
