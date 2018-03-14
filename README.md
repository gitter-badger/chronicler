<div align="center">

# Chronicler
![CircleCI](https://circleci.com/gh/fsanaulla/chronicler.svg?style=shield&circle-token=3943b9e35ee6ec63d54741e57a2833a4609b9adc) [![Coverage Status](https://coveralls.io/repos/github/fsanaulla/chronicler/badge.svg?branch=master)](https://coveralls.io/github/fsanaulla/chronicler?branch=master)

</div>

# About project
Chronicler - asynchronous [Scala](https://www.scala-lang.org/) client library for [InfluxDB](https://www.influxdata.com/).
With several implementation, that allow you choose what you want. It support scala `2.11` and `2.12`.
# Installation
Add to your dependencies list in `build.sbt`:
```
// for Akka based client
libraryDependencies += "com.github.fsanaulla" %% "chronicler-akka-http" % "0.1.0"

// for Netty based client
libraryDependencies += "com.github.fsanaulla" %% "chronicler-async-http" % "0.1.0"

// for UDP protocol client
libraryDependencies += "com.github.fsanaulla" %% "chronicler-udp" % "0.1.0"
```
# Roadmap

| Task | Description | Status |
| ------------- | ------------- | ---------- |
| Macro Formaters | Allow generating `InfluxReader[T]`, `InfluxWriter[T]` at compile time | In Progress |
| Type safe query DSL | More flexible method for quering information | Not started |

# Table of content
- [Helper Tools](docs/helper_tools.md)
- [Set up connection](docs/get_started.md)
- [Database management](docs/database_management.md)
- [Read operation](docs/read_operation_notes.md)
- [Write operation](docs/write_operation_notes.md)
- [User management](docs/user_management.md)
- [Continuously Query management](docs/continuous_query-management.md)
- [Subscription management](docs/subscription_management.md)
- [Retention Policy management](docs/retention_policy_management.md)
- [Shards management](docs/shard_management.md)
