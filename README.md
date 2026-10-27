# GameChange Radar

A simple Clojure application for estimating the risk of code changes in video games.

## Description

GameChange Radar is a project that aims to help game developers identify potentially risky code changes and suggest which parts of the game should be tested.

The current prototype uses three factors:
- Number of dependencies
- Criticality of the changed function
- Size of the code change

Based on these factors, the application calculates a risk score and classifies it as Low, Medium, or High.

It also suggests a test based on the changed function.

## Technologies

- Clojure
- Leiningen

## Usage

Start the Clojure REPL and run:

```clojure
(require 'balance-algorithm.core :reload)
(balance-algorithm.core/-main)
```

## Future Improvements

- Analyze actual code changes using Git
- Automatically identify dependencies between functions
- Use machine learning to predict regression risk
- Generate more detailed test recommendations

## License

This project is licensed under the Eclipse Public License 2.0.
