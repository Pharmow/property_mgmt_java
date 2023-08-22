npm install semantic-release @semantic-release/git @semantic-release/github -D

cat <<EOF > release.config.js
module.exports = {
    branches: "main",
    repositoryUrl: "https://github.com/Pharmow/Terra-practice.git",
    plugins: [
        '@semantic-release/commit-analyzer',
        '@semantic-release/release-notes-generator',
        '@semantic-release/git',
        '@semantic-release/github'
    ]
}
EOF
# # Enter the url of the github repo you want to SemVer on line 6 

# # Semantic versioning nomenclature
# # fix for minor change (patching)
# # feat for slight change (minor version)
# # BREAKING CHANGE for major change (major version)

mkdir -pv .github/workflows
cd ./.github/workflows

cat <<EOF > semver.yaml
name: Semantic Versioning

on:
  push:
    branches:
      - main

jobs:
  semver:
    permissions:
      contents: write
      issues: write
      pull-requests: write
    runs-on: ubuntu-latest
    steps:
      - name: Checkout
        uses: actions/checkout@v2
      - name: Semantic Release
        run: npx semantic-release

EOF

 # env:
        #   GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}