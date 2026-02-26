package com.senai.gestao_escolar.repository;

import com.senai.gestao_escolar.model.Professor;
import com.senai.gestao_escolar.model.Professor;
import com.senai.gestao_escolar.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepository {

    public Professor save(Professor professor) throws SQLException {
        String sql = "INSERT INTO professor (nome, email, disciplina) VALUES (?, ?, ?)";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            statement.setString(1, professor.getNome());
            statement.setString(2, professor.getEmail());
            statement.setString(3, professor.getDisciplina());

            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if(resultSet.next()){
                professor.setId(resultSet.getLong(1));
                return professor;
            }
        }
        return null;
    }

    public List<Professor> list() throws SQLException {
        String sql = "SELECT id, nome, email, disciplina FROM professor";
        List<Professor> professores = new ArrayList<>();

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Professor Professor = new Professor(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );

                professores.add(Professor);
            }
        }
        return professores;
    }

    public Professor findById(long id) throws SQLException {

        String sql = "SELECT id, nome, email, disciplina FROM professor WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                return new Professor(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }
        }
        return null;
    }

    public Professor update(Professor professor) throws SQLException {

        String sql = "UPDATE professor SET nome = ?, email = ?, disciplina = ? WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, professor.getNome());
            statement.setString(2, professor.getEmail());
            statement.setString(3, professor.getDisciplina());

            statement.setLong(4,professor.getId());

            statement.executeUpdate();
            return professor;
        }
    }

    public void delete (long id) throws SQLException {
        String sql = " DELETE FROM professor WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
}
