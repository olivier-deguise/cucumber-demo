package io.github.spoonless.jeu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class JeuDuPenduSteps_EN {

    private JeuDuPendu jeuDuPendu;
    private int nbOccurencesDerniereLettreProposee;

    @Given("the word to be guessed is {word}")
    public void leMotATrouver(String mot) {
        jeuDuPendu = new JeuDuPendu(mot);
    }

    @When("the player suggests the letter {word}")
    public void proposerLettre(String lettre) {
        nbOccurencesDerniereLettreProposee = jeuDuPendu.proposer(lettre.charAt(0));
    }

    @When("the player successively proposes the letters {}")
    public void proposerLettres(String lettresProposees) {
        String[] lettres = lettresProposees.split(", ");
        for (String lettre : lettres) {
            proposerLettre(lettre);
        }
    }

    @Then("the letter is found {int} times")
    public void laLettreEstPresente(int nbFois) {
        assertEquals(nbFois, nbOccurencesDerniereLettreProposee);
    }

    @Then("the word is {}")
    public void leMotEst(String mot) {
        assertEquals(mot, jeuDuPendu.getLettresDecouvertes());
    }

    @Then("the player won")
    public void leJoueurAGagne() {
        assertTrue(jeuDuPendu.isGagne());
    }

    @Then("the player did not won")
    public void leJoueurNAPasGagne() {
        assertFalse(jeuDuPendu.isGagne());
    }

    @Then("the player lost")
    public void leJoueurAPerdu() {
        assertTrue(jeuDuPendu.isPerdu());
    }

    @Then("the player did not lose")
    public void leJoueurNAPasPerdu() {
        assertFalse(jeuDuPendu.isPerdu());
    }
}
