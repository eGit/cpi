
package cpi.groups;

import cpi.Redirect;
import cpi.Margins;

import gap.Request;
import gap.Response;
import gap.data.List;
import gap.hapax.TemplateDataDictionary;
import gap.hapax.TemplateException;
import gap.hapax.TemplateName;
import gap.hapax.TemplateRenderer;
import gap.service.Templates;

import oso.data.Person;

import java.io.IOException;

import javax.servlet.ServletException;

import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.oauth.OAuthService;
import com.google.appengine.api.oauth.OAuthServiceFactory;
import com.google.appengine.api.oauth.OAuthServiceFailureException;

/**
 * Generated once.  This source file will not be overwritten
 * unless deleted, so it can be edited.
 *
 * @see Project
 */
public final class ProjectServlet
    extends gap.service.Servlet
{
    private final static TemplateName ProjectDiv = new TemplateName("div.project.html");



    public ProjectServlet() {
        super();
    }


}