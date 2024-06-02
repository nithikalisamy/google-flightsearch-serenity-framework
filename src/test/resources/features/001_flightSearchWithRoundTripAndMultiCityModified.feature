@demo
Feature: Google flight search

  Background: User starts from the google flights search website
    Given Sally is on the google flights search website

  @roundtrip
  Scenario Outline: Sally searches for a round trip
    When Sally searches for round trip flight
      | Origin        | <origin>       |
      | Destination   | <destination>  |
      | Departure Day | <departureDay> |
      | Return Day    | <returnDay>    |
    #Google flights returns Top or Best string randomly in search results, hence the below text and code will satisfy the condition to pass
    Then Sally should see flights results page with "departing flights"
    When Sally selects the first flight under best flights
    #Google flights returns Top or Best string randomly in search results, hence the below text and code will satisfy the condition to pass
    Then Sally should see flights results page with "returning flights"
    When Sally selects the first flight under best flights
    Then Sally should see flights results page with "Booking options"
    And Sally should see the corresponding flight information for flights selected

    Examples:
      | origin    | destination | departureDay  | returnDay    |
      | Sydney    | New York    | 10 days later | 30 days later |
      | Singapore | Sydney      | 7 days later  | 21 days later |

  @multicity
  Scenario Outline: Sally searches for a multi-city trip
    When Sally searches for multi-city flight
      | Origin          | <origin>        |
      | Destination 1   | <destination1>  |
      | Departure Day 1 | <departureDay1> |
      | Destination 2   | <destination2>  |
      | Departure Day 2 | <departureDay2> |
      | Destination 3   | <destination3>  |
      | Departure Day 3 | <departureDay3> |
    #Google flights returns Top or Best string randomly in search results, hence the below text and code will satisfy the condition to pass
    Then Sally should see flights results page with "flights to <destination1>"
    When Sally selects the first flight under best flights
    #Google flights returns Top or Best string randomly in search results, hence the below text and code will satisfy the condition to pass
    Then Sally should see flights results page with "flights to <destination2>"
    When Sally selects the first flight under best flights
    #Google flights returns Top or Best string randomly in search results, hence the below text and code will satisfy the condition to pass
    Then Sally should see flights results page with "flights to <destination3>"
    When Sally selects the first flight under best flights
    Then Sally should see the corresponding flight information for flights selected

    Examples:
      | origin | destination1 | departureDay1 | destination2 | departureDay2 | destination3 | departureDay3 |
      | Sydney | Singapore    | 7 days later  | New York     | 14 days later | Los Angeles  | 28 days later |