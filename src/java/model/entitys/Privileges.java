/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entitys;

/**
 * This enumeration is for users profiles. Includes the values USER and ADMIN
 *
 * @author javi
 */
public enum Privileges {
    /**
     * The user is a regular user.
     */
    CLIENT,
    /**
     * The user is a privileged user.
     */
    ADMIN;
}
