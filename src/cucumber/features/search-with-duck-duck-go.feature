Feature: Search with Duck Duck Go

Scenario Outline: Successful phrase search with https://duckduckgo.com/
Given Page https://duckduckgo.com/ opened in browser
When Phrase '<searchPhrase>' entered in search input box
And Search button clicked
Then First <meaningfulPositions> search result text contain phrase '<searchPhrase>'
And Save screenshot
And Close browser

  Examples:
|searchPhrase          | meaningfulPositions|
|w pustyni i w puszczy | 5                  |
|pogoda                | 2                  |
|andrzej bobkowski     | 2                  |
