/*
 * responsavel por armazenar o sistema que vai contar e mostrar os dados da tabela 
 */
package modeloBeans;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bruno
 */
public class ModeloTabelas extends AbstractTableModel{
 private ArrayList linhas =null;
 private String[] colunas = null;
 
public ModeloTabelas (ArrayList lin , String []col) {
    setLinhas(lin);
    setColunas(col);
}

    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
 @Override
    public int getColumnCount(){/*conta o numero de colunas */
        return colunas.length;
        
    }
 @Override
    public int getRowCount(){/*conta a quantidade de linhas no array*/
        return linhas.size();
    }
    public String getColumnName(int numCol){/*pega o nome do campo */
        return colunas[numCol];
    }
 @Override
    public Object getValueAt(int numLin,int numCol){/*este metodo que monta a 
        tabela
        */
        Object[]linha=(Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
}

