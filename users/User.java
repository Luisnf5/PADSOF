/**
 * The User class represents a user of the art gallery system.
 * It is an abstract class implementing Serializable.
 * 
 * <p>A user has personal information such as name, surname, NIF, gender, and birth date.
 * It also has a password for authentication and a set of privileges.</p>
 * 
 * <p>Subclasses of User are expected to provide specific implementations for the system.</p>
 * 
 * @author Javier Luis Gael
 */
package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import system.ArtGallery;

public abstract class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String nif;
    private Gender gender;
    private LocalDate birthDate;
    private String password;
    Set<Privileges> privileges = new LinkedHashSet<>();

    /**
     * Constructs a User object with the specified personal information and password.
     * 
     * @param name the name of the user
     * @param surname the surname of the user
     * @param nif the NIF (National Identification Number) of the user
     * @param gender the gender of the user
     * @param birthDate the birth date of the user
     * @param password the password for authentication
     */
    public User(String name, String surname, String nif, Gender gender, LocalDate birthDate, String password){
        this.name = name;
        this.surname = surname;
        this.nif = nif;
        this.gender = gender;
        this.birthDate = birthDate;
        this.password = password;
    }   
    
    /**
     * Constructs a User object with the specified personal information.
     * 
     * @param name the name of the user
     * @param surname the surname of the user
     * @param nif the NIF (National Identification Number) of the user
     * @param gender the gender of the user
     * @param birthDate the birth date of the user
     */
    public User(String name, String surname, String nif, Gender gender, LocalDate birthDate){
        this.name = name;
        this.surname = surname;
        this.nif = nif;
        this.gender = gender;
        this.birthDate = birthDate;
    }
    
    /**
     * Retrieves the name of the user.
     * 
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the NIF (National Identification Number) of the user.
     * 
     * @return the NIF of the user
     */
    public String getNif() {
        return nif;
    }
    
    /**
     * Retrieves the password of the user.
     * 
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }
    
    public String getSurname() {
		return surname;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
     * Validates user credentials.
     * 
     * @param nif the NIF provided for authentication
     * @param pwd the password provided for authentication
     * @return true if credentials are valid, false otherwise
     */
    public Boolean validate_credentials(String nif, String pwd) {
        if (this.nif.equalsIgnoreCase(nif) && this.password.equals(pwd)) {
            return true;
        }
        return false;
    }
    
    /**
     * Changes the password of the user.
     * 
     * @param newPwd the new password to set
     * @return true if the password is changed successfully, false otherwise
     */
    public Boolean changePwd(String newPwd) {
        if (isPwdValid(newPwd) && this == ArtGallery.getSystem().getLoggedUser()) {
            this.password = newPwd;
            return true;
        }
        return false;
    }
    
    /**
     * Checks if a given password is valid.
     * 
     * @param pwd the password to validate
     * @return true if the password is valid, false otherwise
     */
    public boolean isPwdValid(String pwd) {
        char c;
        Boolean hasUppCase = false;
        Boolean hasLowCase = false;
        Boolean hasNumb = false;
        
        for (int i=0 ; i<pwd.length(); i++) {
            c = pwd.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                hasUppCase = true;
            }
            if (c >= 'a' && c <= 'z') {
                hasLowCase = true;
            }
            if (c >= '0' && c <= '9') {
                hasNumb = true;
            }
        }
        
        if (hasUppCase && hasLowCase && hasNumb) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if a given password is valid.
     * 
     * @param pwd the password to validate
     * @return true if the password is valid, false otherwise
     */
    public static boolean isPwdValidStatic(String pwd) {
        char c;
        Boolean hasUppCase = false;
        Boolean hasLowCase = false;
        Boolean hasNumb = false;
        
        for (int i=0 ; i<pwd.length(); i++) {
            c = pwd.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                hasUppCase = true;
            }
            if (c >= 'a' && c <= 'z') {
                hasLowCase = true;
            }
            if (c >= '0' && c <= '9') {
                hasNumb = true;
            }
        }
        
        if (hasUppCase && hasLowCase && hasNumb) {
            return true;
        }
        return false;
    }
    
    /**
     * Changes the name of the user.
     * 
     * @param newName the new name to set
     */
    public void changeName(String newName) {
            this.name = newName;
    }
    
    /**
     * Changes the nif of the user.
     * 
     * @param newNif the new name to set
     */
    public void changeNif(String newNif) {
            this.nif = newNif;
    }
    
    /**
     * Changes the surname of the user.
     * 
     * @param newSurname the new surname to set
     */
    public void changeSurname(String newSurname) {
            this.surname = newSurname;
    }
    
    /**
     * Changes the birth date of the user.
     * 
     *

 @param newBirthDate the new birth date to set
     * @return true if the birth date is changed successfully, false otherwise
     */
    public boolean changeBirthDate(LocalDate newBirthDate) {
        if (newBirthDate.isBefore(LocalDate.now()) || this == ArtGallery.getSystem().getLoggedUser()) {
            this.birthDate = newBirthDate;
            return true;
        }
        
        return false;
    }
    
    /**
     * Checks if the user has a specific privilege.
     * 
     * @param p the privilege to check
     * @return true if the user has the privilege, false otherwise
     */
    public boolean hasPrivilege(Privileges p) {
        return this.privileges.contains(p);
    }
    
    /**
     * Adds a privilege to the user.
     * 
     * @param p the privilege to add
     */
    public void addPrivilege(Privileges p) {
        this.privileges.add(p);
    }
    
    public void deletePrivilege(Privileges p) {
    	this.privileges.remove(p);
    }

}