package com.senai.gestao_escolar.repository;

import com.senai.gestao_escolar.model.Curso;
import com.senai.gestao_escolar.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository{

    public Curso save (Curso curso) throws SQLException {
        String sql = "INSERT INTO curso (nome, codigo) VALUES ( ?, ? )";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getCodigo());

            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()){
                curso.setId(resultSet.getLong(1));
                return curso;
            }
        }
        return null;
    }

    public List<Curso> list() throws SQLException {
        String sql = "SELECT id, nome, codigo FROM curso";
        List<Curso> cursos = new ArrayList<>();

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Curso curso = new Curso(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );

                cursos.add(curso);
            }
        }
        return cursos;
    }

    public Curso findById(long id) throws SQLException {

        String sql = "SELECT id, nome, codigo FROM curso WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                return new Curso(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
        }
        return null;
    }

    public Curso update(Curso curso) throws SQLException {

        String sql = "UPDATE curso SET nome = ?, codigo = ? WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getCodigo());

            statement.setLong(3,curso.getId());

            statement.executeUpdate();
            return curso;
        }
    }

    public void delete (long id) throws SQLException {
        String sql = " DELETE FROM curso WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
}
