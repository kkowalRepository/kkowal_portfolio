Feature: Context Menu functionality
  Context menu items are custom additions that appear in the right-click menu.
  Right-click in the box to trigger a JavaScript alert.

  @contextMenuTest
  Scenario: checking the context menu functionality
    Given user is on a herokuapp page
    When user clicks "context menu" form the list
    And user is on "context menu" page
    And user rightclicks the box to trigger a JavaScript alert
    Then user can see an alert