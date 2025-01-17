/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author User
 */
public class TaskTableModel extends AbstractTableModel {

    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"}; //colunas que vai aparecer na table
    List<Task> tasks = new ArrayList(); //lista de tarefas

    @Override
    public int getRowCount() {
        return tasks.size(); //quantas linhas vai ter
    }

    @Override
    public int getColumnCount() {
        return columns.length; //retorna o nº de colunas
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex]; //retorna o nome das colunas
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) { //deixar a coluna editavel
        return columnIndex == 3;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (tasks.isEmpty()) {
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0 -> {
                return tasks.get(rowIndex).getName();
            }
            case 1 -> {
                return tasks.get(rowIndex).getDescription();
            }
            case 2 -> {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            }
            case 3 -> {
                return tasks.get(rowIndex).isIsCompleted();
            }
            case 4 -> {
                return "";
            }
            case 5 -> {
                return "";
            }
            default -> {
                return "Dados não encontrados";
            }
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setIsCompleted((boolean) aValue);
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
