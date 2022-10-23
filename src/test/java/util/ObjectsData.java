package util;

import objects.api.Project;
import objects.api.Suite;
import ui_tests.BaseTest;

public class ObjectsData extends BaseTest {

        public static Project projectData = Project.builder()
                .name("Test Project")
                .build();

        public static Suite suiteData = Suite.builder()
                .name("This is test suite name")
                .description("No info")
                .build();
}
