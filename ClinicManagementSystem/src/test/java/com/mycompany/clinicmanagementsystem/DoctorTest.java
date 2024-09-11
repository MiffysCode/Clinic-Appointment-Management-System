/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.clinicmanagementsystem;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MIFFY
 */
public class DoctorTest {
    
    public DoctorTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testGetId() {
        System.out.println("getId");
        Doctor instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testGetName() {
        System.out.println("getName");
        Doctor instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpecialization method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testGetSpecialization() {
        System.out.println("getSpecialization");
        Doctor instance = null;
        String expResult = "";
        String result = instance.getSpecialization();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableSlots method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testGetAvailableSlots() {
        System.out.println("getAvailableSlots");
        Doctor instance = null;
        List<String> expResult = null;
        List<String> result = instance.getAvailableSlots();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAvailableSlot method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testAddAvailableSlot() {
        System.out.println("addAvailableSlot");
        String slot = "";
        Doctor instance = null;
        instance.addAvailableSlot(slot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAvailableSlot method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testRemoveAvailableSlot() {
        System.out.println("removeAvailableSlot");
        String slot = "";
        Doctor instance = null;
        instance.removeAvailableSlot(slot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAvailability method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testDisplayAvailability() {
        System.out.println("displayAvailability");
        Doctor instance = null;
        instance.displayAvailability();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeDefaultSlots method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testInitializeDefaultSlots() {
        System.out.println("initializeDefaultSlots");
        Doctor instance = null;
        instance.initializeDefaultSlots();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
        System.out.println("toString");
        Doctor instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DoctorImpl extends Doctor {

        public DoctorImpl() {
            super("", "", "");
        }

        public void displayAvailability() {
        }
    }
    
}
