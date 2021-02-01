package interfaceDaoLibrairie;

import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import entitesLibrairie.LigneCommande;

public interface iDaoLigneCommande {

	public void addLigneCommande(LigneCommande ligneCde, String cdeNum, String livreIsbn, String ClientLogin) throws SQLException;

	public Vector<LigneCommande> vectorListLigneCde() throws SQLException;

	public DefaultTableModel listeLigneCde() throws SQLException;

}