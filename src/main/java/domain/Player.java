package domain;

import exception.DomainException;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Dries
 */
@Entity
public class Player implements Serializable {
    
    private String firstName;
    private String lastName;
    private int playerNumber;
    private int goals;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public Player(){
        
    }
    
    public Player(String firstName, String lastName, int playerNumber, int goals) throws DomainException {
        setFirstName(firstName);
        setLastName(lastName);
        setPlayerNumber(playerNumber);
        setGoals(goals);
    }
    
     public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws DomainException {
        if(firstName == null || firstName.equals("")){
            throw new DomainException("The first name is empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws DomainException {
         if(lastName == null || lastName.equals("")){
            throw new DomainException("The last name is empty.");
        }
        this.lastName = lastName;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) throws DomainException {
        if(playerNumber == 0 || playerNumber < 0 || playerNumber > 99){
            throw new DomainException("The player number is not valid.");
        }
        this.playerNumber = playerNumber;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) throws DomainException {
         if(goals < 0){
            throw new DomainException("The number of goals is not valid.");
        }
        this.goals = goals;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Player[ id=" + id + " ]";
    }
    
}
