Feature: Withdraw fixed amount

  Scenario Outline:
    Given I have <Balance> in my account
    When I choose to withdraw the fixed amount of <Withdrawal>
    Then I should <Outcome>
    And the balance of my account should be <Remaining>

    Examples:
    |Balance|Withdrawal|Remaining|Outcome               |
    |$500   |$50       |$450     |Receive $50 cash      |
    |$500   |$100      |$400     |Receive $100 cash     |
    |$500   |$200      |$300     |Receive $200 cash     |
    |$100   |$200      |$100     |See an error message  |