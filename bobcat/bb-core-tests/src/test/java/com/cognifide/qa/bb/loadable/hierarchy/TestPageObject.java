/*
 * Copyright 2016 Cognifide Ltd..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognifide.qa.bb.loadable.hierarchy;

import com.cognifide.qa.bb.loadable.annotation.LoadableComponent;
import com.cognifide.qa.bb.loadable.condition.impl.VisibilityCondition;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.test.actions.BobcatActionsTest;
import com.cognifide.qa.test.util.PageUtils;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class TestPageObject {

  @Inject
  private WebDriver webDriver;

  @FindBy(tagName = "input")
  @LoadableComponent(condClass = TestCondition.class, delay = 5, timeout = 5)
  private WebElement inputElement;

  @FindBy(tagName = "invalidTag")
  @LoadableComponent(condClass = VisibilityCondition.class, delay = 5, timeout = 5)
  private WebElement invalidElement;

  public void open() {
    webDriver.get(PageUtils.buildTestPageUrl(BobcatActionsTest.class));
  }

  public void sendKeysWithSuccess() {
    inputElement.sendKeys("test");
  }

  public void sendKeysWithFailure() {
    invalidElement.sendKeys("test");
  }
}
