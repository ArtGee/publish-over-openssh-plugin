/*
 * The MIT License
 *
 * Copyright (C) 2010-2011 by Anthony Robinson
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package io.jenkins.plugins.publish_over_openssh.options;

import hudson.Extension;
import hudson.model.Describable;
import hudson.model.Descriptor;
import jenkins.model.Jenkins;
import jenkins.plugins.publish_over.options.PublisherLabelOptions;
import io.jenkins.plugins.publish_over_openssh.BapSshPublisherLabel;
import org.kohsuke.stapler.DataBoundConstructor;

public class SshOverridePublisherLabelDefaults implements PublisherLabelOptions, Describable<SshOverridePublisherLabelDefaults> {

    private final String label;

    @DataBoundConstructor
    public SshOverridePublisherLabelDefaults(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public SshOverridePublisherLabelDefaultsDescriptor getDescriptor() {
        return Jenkins.getActiveInstance().getDescriptorByType(SshOverridePublisherLabelDefaultsDescriptor.class);
    }

    @Extension
    public static class SshOverridePublisherLabelDefaultsDescriptor extends Descriptor<SshOverridePublisherLabelDefaults> {

        @Override
        public String getDisplayName() {
            return "SshOverridePublisherLabelDefaultsDescriptor - not visible ...";
        }

        public jenkins.plugins.publish_over.view_defaults.PublisherLabel.Messages getCommonFieldNames() {
            return new jenkins.plugins.publish_over.view_defaults.PublisherLabel.Messages();
        }

        public String getConfigPage() {
            return getViewPage(BapSshPublisherLabel.class, "config.jelly");
        }

    }

}