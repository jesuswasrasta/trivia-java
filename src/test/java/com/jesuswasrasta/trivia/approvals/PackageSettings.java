package com.jesuswasrasta.trivia.approvals;

import java.io.File;

/**
 * If you want to setup ApprovalTests library, create this class
 *
 * @link https://github.com/approvals/ApprovalTests.Java/blob/master/approvaltests/docs/Configuration.md
 */
public class PackageSettings
{
  /**
   * Setting a different base folders for output files
   *
   * @link https://github.com/approvals/ApprovalTests.Java/blob/master/approvaltests/docs/Configuration.md#alternative-base-directory-for-output-files
   */


  private File getFilenameBySeed(String folderName) {
    String baseDir = System.getProperty("user.dir");
    return new File(baseDir + "/src/test/approvals/" + folderName);
  }
  public static String UseApprovalSubdirectory = "approved";
}