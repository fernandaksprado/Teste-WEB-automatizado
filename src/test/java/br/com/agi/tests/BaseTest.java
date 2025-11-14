package br.com.agi.tests;

import br.com.agi.core.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = DriverFactory.getDriver();
    }

    @AfterEach
    public void teardown(TestInfo testInfo) {
        try {
            // --- CAPTURA DE EVIDÊNCIA ---
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);

            String fileName = "evidence_" +
                    testInfo.getDisplayName().replace(" ", "_") +
                    "_" + System.currentTimeMillis() + ".png";

            File dest = new File("evidences/" + fileName);
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());

            System.out.println("Evidência salva: " + dest.getAbsolutePath());

            // --- ATUALIZA README ---
            updateReadme(testInfo.getDisplayName(), fileName);

        } catch (Exception e) {
            System.out.println("Erro ao capturar evidência ou atualizar README: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
        }
    }

    private void updateReadme(String testName, String evidenceFile) {
        try {
            Path readmePath = Paths.get("README.md");

            String date = java.time.LocalDateTime.now()
                    .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            String entry =
                    "\n### Execução (" + date + ")\n" +
                    "- Teste: **" + testName + "**\n" +
                    "- Evidência: `" + evidenceFile + "`\n";

            String original = new String(Files.readAllBytes(readmePath));
            String updated = original + entry;

            Files.write(readmePath, updated.getBytes());

            System.out.println("README atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Falha ao atualizar README: " + e.getMessage());
        }
    }
}
