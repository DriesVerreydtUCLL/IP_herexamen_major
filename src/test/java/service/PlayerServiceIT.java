package service;

import domain.Player;
import exception.ServiceException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Dries
 */
public class PlayerServiceIT {
    
    private static PlayerService instance;
    private static final String dbType = "Memory";
    
    public PlayerServiceIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() throws ServiceException {
        instance = new PlayerService(dbType);
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getPlayers method, of class PlayerService.
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testGetPlayers() throws Exception {
        System.out.println("getPlayers");
        int expResult = 5;
        int result = instance.getPlayers().size();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getPlayer method, of class PlayerService.
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testGetPlayer() throws Exception {
        System.out.println("getPlayer");
        Player player = new Player("Dries","Verreydt",99,10);
        System.out.println(player.getId());
        instance.addPlayer(player);
        System.out.println(player.getId());
        Player result = instance.getPlayer(player.getId());
        assertEquals(player, result);
    }
    
    /**
     * Test of addPlayer method, of class PlayerService.
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testAddPlayer() throws Exception {
        System.out.println("addPlayer");
        Player player = new Player("Dries","Verreydt",99,10);
        instance.addPlayer(player);
        boolean contains = false;
        for(Player p : instance.getPlayers()){
            if(p.equals(player)){
                contains = true;
            }
        }
        assertTrue(contains);
    }

    /**
     * Test of removePlayer method, of class PlayerService.
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testRemovePlayer() throws Exception {
        System.out.println("removePlayer");
        Player player = new Player("Dries","Verreydt",99,10);
        instance.addPlayer(player);
        Long id = player.getId();
        instance.removePlayer(id);
        boolean contains = false;
        for(Player p : instance.getPlayers()){
            if(p.equals(player)){
                contains = true;
            }
        }
        assertFalse(contains);
    }

    /**
     * Test of updatePlayer method, of class PlayerService.
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testUpdatePlayer() throws Exception {
        System.out.println("updatePlayer");
        Player player = new Player("Dries","Verreydt",99,10);
        instance.addPlayer(player);
        String expName = "Wout";
        player.setFirstName(expName);
        instance.updatePlayer(player);
        String firstName = instance.getPlayer(player.getId()).getFirstName();
        assertEquals(firstName,expName);
    }

    /**
     * Test of getAvgGoals method, of class PlayerService.
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testGetAvgGoals() throws Exception {
        System.out.println("getAvgGoals");
        double expResult = 2.0;
        double result = instance.getAvgGoals();
        assertEquals(expResult, result, 2.0);
    }

    /**
     * Test of getTopScorer method, of class PlayerService.
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testGetTopScorer() throws Exception {
        System.out.println("getTopScorer");
        String expResult = "Hazard";
        Player result = instance.getTopScorer();
        assertEquals(expResult, result.getLastName());
    }
    
}
