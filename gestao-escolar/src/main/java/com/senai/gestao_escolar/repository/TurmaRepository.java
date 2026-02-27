package com.senai.gestao_escolar.repository;

import com.senai.gestao_escolar.model.Turma;
import com.senai.gestao_escolar.utils.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {

    public Turma save(Turma turma) throws SQLException {
        String sql = "INSERT INTO turma (nome, curso_id, professor_id) VALUES (?, ?, ?)";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            statement.setString(1, turma.getNome());
            statement.setLong(2, turma.getCurso_id());
            statement.setLong(3, turma.getProfessor_id());


            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if(resultSet.next()){
                turma.setId(resultSet.getLong(1));
                return turma;
            }
        }
        return null;
    }

    public List<Turma> list() throws SQLException {
        String sql = "SELECT id, nome, curso_id, professor_id FROM turma";
        List<Turma> turmas = new ArrayList<>();

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Turma turma = new Turma(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getLong(3),
                        resultSet.getLong(4)
                );

                turmas.add(turma);
            }
        }

        return turmas;
    }

    public Turma findById(long id) throws SQLException {

        String sql = "SELECT id, nome, curso_id, prfessor_id FROM turma WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                return new Turma(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getLong(3),
                        resultSet.getLong(4)
                );
            }
        }
        return null;
    }

    public Turma update(Turma turma) throws SQLException {

        String sql = " UPDATE turma SET nome = ?, curso_id = ?, prfessor_id = ?, data_nascimento = ? WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, turma.getNome());
            statement.setLong(2, turma.getProfessor_id());
            statement.setLong(3,turma.getCurso_id());

            statement.setLong(5,turma.getId());

            statement.executeUpdate();
            return turma;
        }
    }

    public void delete (long id) throws SQLException {
        String sql = " DELETE FROM turma WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
}
