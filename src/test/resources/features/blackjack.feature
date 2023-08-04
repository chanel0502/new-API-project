Feature: Verifying for blackjack

  @api
  Scenario: Verify shuffle and remaining services

    Given user hits get new deck api with "https://deckofcardsapi.com/api/deck/new/"
    Then user verifies total remaining to be "52" and not shuffled
    And user hits shuffle api with same deck id
    Then user verifies for shuffled value to be "true"
    Then user hits draw api two times with same deck id with count "3"
    And user verifies remaining cards to be "46"

