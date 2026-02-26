package com.senai.gestao_escolar.repository;

import com.senai.gestao_escolar.model.Aluno;
import com.senai.gestao_escolar.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepository {

    public Aluno save(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno (nome, email, matricula, data_nascimento) VALUES (?, ?, ?, ?)";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getEmail());
            statement.setString(3, aluno.getMatricula());
            statement.setObject(4, aluno.getData_nascimento());

            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if(resultSet.next()){
                aluno.setId(resultSet.getLong(1));
                return aluno;
            }
        }
        return null;
    }

    public List<Aluno> list() throws SQLException {
        String sql = "SELECT id, nome, email, matricula, data_nascimento FROM aluno";
        List<Aluno> alunos = new ArrayList<>();

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Aluno aluno = new Aluno(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate()
                );

                alunos.add(aluno);
            }
        }

        return alunos;
    }

    public Aluno findById(long id) throws SQLException {

        String sql = "SELECT id, nome, email, matricula, data_nascimento FROM aluno WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                return new Aluno(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate()
                );
            }
        }
        return null;
    }

    public Aluno update(Aluno aluno) throws SQLException {

        String sql = " UPDATE aluno SET nome = ?, email = ?, matricula = ?, data_nascimento = ? WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getEmail());
            statement.setString(3,aluno.getMatricula());
            statement.setObject(4,aluno.getData_nascimento());

            statement.setLong(5,aluno.getId());

            statement.executeUpdate();
            return aluno;
        }
    }

    public void delete (long id) throws SQLException {
        String sql = " DELETE FROM aluno WHERE id = ?";

        try(Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
}
