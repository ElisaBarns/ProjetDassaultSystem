/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Detail_offre;
import Entity.Offre;
import Entity.Piste_opportunite;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mel
 */
@Stateless
public class OffreFacade extends AbstractFacade<Offre> implements OffreFacadeLocal {

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OffreFacade() {
        super(Offre.class);
    }
    
    
    //Créer offre
    @Override
    public void CreerOffre(int remise, String conditions, Piste_opportunite piste) {
    System.out.println(remise);
    System.out.println(conditions);
    System.out.println(piste);

    Offre o=new Offre();
    o.setRemise(remise);
    o.setConditions(conditions);
    o.setLaPisteOpportunite(piste);
    //ArrayList<Detail_offre> contenu = new ArrayList();
    //o.setContenu(contenu);
    o.setDate_creation_offre(new Date());
        //o.calculerMontant();
        //o.calculerTotal();
    //o.setP_somme(0);
    //o.setP_total(0);
    getEntityManager().persist(o);
    }
    
    //Modifier offre
    @Override
    public void ModifierOffre(Offre o, int remise, String conditions) {
    o.setRemise(remise);
    o.setConditions(conditions);
    ArrayList<Detail_offre> contenu = o.getContenu();
    List<Detail_offre> lesdetails = o.getLesDetail_offres();
        //rechercher les instances de detail pour alimenter la liste
        int i = 1;
        Offre of = lesdetails.get(i).getUneOffre();
        while (i<lesdetails.size()) 
        {
            if (of==o)
            {
                contenu.add(lesdetails.get(i));
            }
            else
            {
                i++;
            }
        }
    o.setContenu(contenu);
    o.setDate_modif_offre(new Date()); //On récupère la date du système
        float p1 = o.calculerMontant();
        float p2 = o.calculerTotal();
    o.setP_somme(p1);
    o.setP_total(p2);
    getEntityManager().merge(o);
    }
    
        @Override
    public Offre RechercherOffreParId(long id) {
    Offre o=null;
    List<Offre> result;
    String txt="SELECT o FROM Offre AS o WHERE o.id=:id";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("id", id);
    result=req.getResultList();
    if(result.size()==1){
        o=(Offre)result.get(0);
    }
    return o;        
    }

    @Override
    public ArrayList<Detail_offre> ModifierContenu(Offre offre) {
       ArrayList<Detail_offre> contenu = new ArrayList();
        
        return contenu;
    }
    
    
    
}
