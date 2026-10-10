![Of Their Own Accord](docs/assets/otoa-logo.png)

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

Output: `build/libs/otoa-0.2.0.jar`. Set the mod version and other identity values in `gradle.properties`.

Run each development launch in its own terminal:

```powershell
.\gradlew.bat runClient
.\gradlew.bat runServer
.\gradlew.bat runClientTwo
```

These use separate folders in `runs/client/`, `runs/server/`, and `runs/client-two/`. The second client uses the player name **DevTwo** for multiplayer testing. Check **Mods** for **Of Their Own Accord** and each run's `logs/latest.log` for `Of Their Own Accord (otoa) initialized.`

Run the development server from an interactive terminal. A ready server logs `Done`; enter `stop` in that terminal to save the test world and shut it down cleanly. If a launch stops and creates `runs/server/eula.txt`, read the [Minecraft EULA](https://www.minecraft.net/eula); if you agree, set `eula=true` and launch again.

For local multiplayer testing, set `online-mode=false` and `server-ip=127.0.0.1` in `runs/server/server.properties` while the server is stopped. Connect both clients through **Multiplayer → Direct Connection → `127.0.0.1:25565`**. To allow commands, enter `op Dev` in the server terminal after **Dev** joins.

On Linux or macOS, use `bash ./gradlew` with the same task names. See the [NeoForge setup guide](https://docs.neoforged.net/docs/1.21.1/gettingstarted/) for IDE setup.

## NPC testing

With cheats enabled in single-player, or operator permissions on a server:

```text
/summon otoa:human ~ ~ ~2
```

Human NPCs use the Steve appearance, wander, and look at nearby players. Right-click with an empty hand to display the NPC's name and UUID in your chat. Its UUID remains the same when the world is saved and reloaded.

## Layout

| Path | Purpose |
| --- | --- |
| `docs/assets/` | Public artwork used by the README and documentation. |
| `src/main/java/com/lamprophonia/otoa/` | Java source; `OfTheirOwnAccord.java` is the common entry point. |
| `src/main/java/com/lamprophonia/otoa/npc/` | NPC movement goals, interaction, and persistence behavior. |
| `src/main/java/com/lamprophonia/otoa/registry/` | Entity registration and default attributes. |
| `src/main/java/com/lamprophonia/otoa/client/` | Client-only entry point and presentation registration. |
| `src/main/java/com/lamprophonia/otoa/client/renderer/` | NPC model and texture selection for rendering. |
| `src/main/resources/assets/otoa/` | In-game client resources; `lang/en_us.json` contains English display text. |
| `src/main/templates/META-INF/neoforge.mods.toml` | Mod metadata template, expanded during the build. |
| `gradle.properties` | Mod identity and runtime versions. |
| `build.gradle` | Compilation, packaging, metadata generation, and launch tasks. |
| `settings.gradle` | Project name and plugin lookup. |
| `gradle/wrapper/`, `gradlew`, `gradlew.bat` | Pinned Gradle distribution and launch scripts. |
| `.gitignore`, `.gitattributes` | Generated-file exclusions and line-ending rules. |
| `TEMPLATE_LICENSE.txt` | Original NeoForge starter license notice. |
| `build/` | Generated output, ignored by Git. |
| `runs/` | Separate client, second-client, and server worlds, configuration, and logs, ignored by Git. |

Client resources belong under `src/main/resources/assets/otoa/`; server data, when added, belongs under `src/main/resources/data/otoa/`. Keep server gameplay code separate from client-only presentation. Edit source templates rather than generated files in `build/`.

## Testing

Test the built JAR in a separate Minecraft 1.21.1 / NeoForge 21.1.251 installation by placing it in that profile's `mods/` folder. Test ATM10 in a separate 8.2 profile. Use fresh test worlds and preserve existing saves.

Verified on Windows: build; NPC spawning, movement, and identity interaction in single-player and on a dedicated server; save/reload and server-restart persistence; two-player synchronization and private identity messages. The packaged JAR also passed standalone NeoForge and basic ATM10 8.2 checks, including ATM10 save/reload persistence. Full modpack gameplay compatibility remains unverified. Automated tests are not yet defined.

License metadata: `All Rights Reserved`. The NeoForge starter notice is retained in `TEMPLATE_LICENSE.txt` and packaged with the mod.
