/*
 * Copyright 2018 Niels Gron and Contributors All Rights Reserved.
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

package org.apache.webapp.simpleui.bootstrap4.components;

import org.apache.webapp.simpleui.HtmlStream;
import org.apache.webapp.simpleui.bootstrap4.layouts.BSLayoutManager;

import java.util.ArrayList;

public abstract class BSComponentContainer extends BSComponent {

    private BSLayoutManager layoutManager = null; // BSFlowLayout.INSTANCE;
    protected ArrayList<BSComponent> children = new ArrayList<BSComponent>();

    public BSComponent add(BSComponent component) {
        if ( component == null ) {
            return null;
        }
        children.add(component);

        if ( layoutManager != null ) {
            layoutManager.add(component);
        }
        return component;
    }

    public BSComponent add(BSComponent component, Object constraint) {
        if ( component == null ) {
            return null;
        }
        children.add(component);

        if ( layoutManager != null ) {
            layoutManager.add(component, constraint);
        }
        return component;
    }

    public void remove(BSComponent component) {
        if ( component == null ) {
            return;
        }
        children.remove(component);
    }

    public BSComponent get(int index) {
        if ( children.size() == 0 ) {
            return null;
        }
        if ( index >= children.size() ) {
            return null;
        }
        return children.get(index);
    }

    public int getChildrenCount() {
        return children.size();
    }

    public void setLayout(BSLayoutManager layout) {
        layoutManager = layout;
    }
    public BSLayoutManager getLayout() {
        return layoutManager;
    }

    public void render(HtmlStream stream) {

        if ( layoutManager != null ) {
            layoutManager.render(stream);
        } else {
            // Render each of the children components
            for (int i = 0; i < children.size(); i++) {
                children.get(i).render(stream);
            }
        }

    }

}