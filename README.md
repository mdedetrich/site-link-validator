# Site Link Validator

A fork of [ennru's site link validator](https://github.com/ennru/site-link-validator) which has been migrated
to use [Apache Pekko](https://pekko.apache.org/) along with additional features

Validates URLs in locally stored web pages to reduce broken links and links that point to a redirecting URL. For local pages the HTML anchors are validated.

The tool generates a report identifying files and links that should be fixed.

The configuration file identifies a page root and allows disabling checks for certain URLs and files.

See [application.conf](core/src/main/resources/application.conf) for examples.

This software is open source and released under [Apache License V2](LICENSE).
