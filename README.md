# Cardano Common Library

<p align="left">
<img alt="Tests" src="https://github.com/cardano-foundation/cf-java-cardano-common-explorer/actions/workflows/tests.yaml/badge.svg" />
<img alt="Release" src="https://github.com/cardano-foundation/cf-java-cardano-common-explorer/actions/workflows/release.yaml/badge.svg?branch=main" />
<img alt="Publish" src="https://github.com/cardano-foundation/cf-java-cardano-common-explorer/actions/workflows/publish.yaml/badge.svg?branch=main" />
<a href="https://conventionalcommits.org"><img alt="conventionalcommits" src="https://img.shields.io/badge/Conventional%20Commits-1.0.0-%23FE5196?logo=conventionalcommits" /></a>
</p>

## Getting Started

To make use of this project, you need to add the following lines to the pom.xml file.

```
<repositories>
    ...
    <repository>
        <id>gitlab-private-registry</id>
        <url>https://pro.gitlab.metadata.dev.cf-deployments.org/api/v4/projects/2/packages/maven</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
```

```
<dependency>
    <groupId>org.cardanofoundation.explorer</groupId>
    <artifactId>consumer-common</artifactId>
    <version>0.1.7</version>
</dependency>
```




