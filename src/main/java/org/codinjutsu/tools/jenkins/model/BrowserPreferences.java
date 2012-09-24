/*
 * Copyright (c) 2012 David Boissier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codinjutsu.tools.jenkins.model;

import org.apache.commons.lang.StringUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BrowserPreferences {

    private final List<String> favoriteJobs = new LinkedList<String>();
    private String lastSelectedViewName;

    public void addFavorite(String jobName) {
        favoriteJobs.add(jobName);
    }

    public boolean isAFavoriteJob(String jobName) {
        return favoriteJobs.contains(jobName);
    }

    public void removeFavorite(Job selectedJob) {
        for (Iterator<String> iterator = favoriteJobs.iterator(); iterator.hasNext(); ) {
            String jobName  =  iterator.next();
            if (StringUtils.equals(selectedJob.getName(), jobName)) {
                iterator.remove();
            }
        }
        favoriteJobs.clear();
    }

    public void setLastSelectedView(String viewName) {
        this.lastSelectedViewName = viewName;
    }

    public String getLastSelectedView() {
        return lastSelectedViewName;
    }
}
