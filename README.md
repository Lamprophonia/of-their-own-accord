![Of Their Own Accord](docs/assets/otoa-logo.png)

# Of Their Own Accord

OTOA is a Minecraft NPC mod in early development. Mod ID: `otoa`.

## Requirements

- Minecraft 1.21.1 and NeoForge 21.1.251.
- A 64-bit Java 21 JDK, with `JAVA_HOME` and `PATH` configured.
- Internet access for the first build's dependencies.

The Gradle wrapper supplies Gradle 9.2.1; ModDevGradle is pinned to 2.0.148. The initial modpack target is [ATM10 8.2](https://www.curseforge.com/minecraft/modpacks/all-the-mods-10/files/8945086).

## Build and run

From the repository root in PowerShell:

```powershell
.\gradlew.bat build
```

Output: `build/libs/otoa-0.1.0.jar`. Set the mod version and other identity values in `gradle.properties`.

Launch the development client or dedicated server:

```powershell
.\gradlew.bat runClient
.\gradlew.bat runServer
```

These use separate profiles in `runs/client/` and `runs/server/`. Check **Mods** for **Of Their Own Accord** and the profile's `logs/latest.log` for `Of Their Own Accord (otoa) initialized.`

Run the development server from an interactive terminal. A ready server logs `Done`; enter `stop` in that terminal to save the test world and shut it down cleanly. If a launch stops and creates `runs/server/eula.txt`, read the [Minecraft EULA](https://www.minecraft.net/eula); if you agree, set `eula=true` and launch again.

On Linux or macOS, use `bash ./gradlew` with the same task names. See the [NeoForge setup guide](https://docs.neoforged.net/docs/1.21.1/gettingstarted/) for IDE setup.

## Layout

| Path | Purpose |
| --- | --- |
| `docs/assets/` | Public artwork used by the README and documentation. |
| `src/main/java/com/lamprophonia/otoa/` | Java source; `OfTheirOwnAccord.java` is the common entry point. |
| `src/main/templates/META-INF/neoforge.mods.toml` | Mod metadata template, expanded during the build. |
| `gradle.properties` | Mod identity and runtime versions. |
| `build.gradle` | Compilation, packaging, metadata generation, and launch tasks. |
| `settings.gradle` | Project name and plugin lookup. |
| `gradle/wrapper/`, `gradlew`, `gradlew.bat` | Pinned Gradle distribution and launch scripts. |
| `.gitignore`, `.gitattributes` | Generated-file exclusions and line-ending rules. |
| `TEMPLATE_LICENSE.txt` | Original NeoForge starter license notice. |
| `build/` | Generated output, ignored by Git. |
| `runs/client/`, `runs/server/` | Development worlds, configuration, and logs, ignored by Git. |

Assets and data, when added, belong under `src/main/resources/assets/otoa/` and `src/main/resources/data/otoa/`. Keep server gameplay code separate from client-only presentation. Edit source templates rather than generated files in `build/`.

## Testing

Test the built JAR in a separate Minecraft 1.21.1 / NeoForge 21.1.251 installation by placing it in that profile's `mods/` folder. Test ATM10 in a separate 8.2 profile. Use fresh test worlds and preserve existing saves.

Verified on Windows: build, development client, dedicated-server startup and clean shutdown, packaged-JAR loading, and ATM10 8.2 startup and new-world creation. Full gameplay compatibility remains untested. Automated tests are not yet defined.

License metadata: `All Rights Reserved`. The NeoForge starter notice is retained in `TEMPLATE_LICENSE.txt` and packaged with the mod.
