/*
 * Gap Data
 * Copyright (C) 2009 John Pritchard
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */
package cpi.groups;

import oso.data.Person;
import cpi.Redirect;
import cpi.Margins;

import gap.data.*;
import gap.util.*;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.blobstore.*;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;

/**
 * Generated short list.
 */
@Generated(value={"gap.service.OD","ListShort.java"},date="2012-02-01T20:10:14.280Z")
public abstract class ListShortProjectMember
    extends gap.util.AbstractList<Member>
    implements gap.data.List.Short<Member>
{

    private final static long serialVersionUID = 1;

    public final static String ParentTypeName = "Project";

    public final static String ChildTypeName = "Member";

    public final static Class ParentTypeClass = Project.class;

    public final static Class ChildTypeClass = Member.class;


    protected transient Project parent;


    public ListShortProjectMember(Project parent) {
        this();
        if (null != parent){
            this.parent = parent;
            this.setValueClassAncestorKey();
        }
        else
            throw new IllegalArgumentException();
    }
    public ListShortProjectMember(){
        super();
        /*
         * Not Paging -- Short lists are for small membership.
         */
    }


    public void destroy(){
        this.parent = null;
        this.clearBuffer();
    }
    public Project getParent(){
        Project parent = this.parent;
        if (null == parent){
            Key parentKey = this.ancestorKey;
            if (null != parentKey){
                parent = Project.Get(parentKey);
                if (null != parent)
                    this.parent = parent;
                else
                    throw new IllegalStateException("Missing parent, user employed wrong constructor (pre store).");
            }
            else
                throw new IllegalStateException("Missing ancestor key.");
        }
        return parent;
    }
    public String getParentTypeName(){
        return ParentTypeName;
    }
    public String getChildTypeName(){
        return ChildTypeName;
    }
    public Class getParentTypeClass(){
        return ParentTypeClass;
    }
    public Class getChildTypeClass(){
        return ChildTypeClass;
    }
    public void setValueClassAncestorKey(){
        Key key = this.getParent().getKey();
        if (key != this.ancestorKey){
            this.ancestorKey = key;
            this.query = Member.CreateQueryFor(this.ancestorKey);
        }
    }
    public Member fetch(Filter filter){
        Key ancestor = this.ancestorKey;
        if (null != ancestor){
            Query query = Member.CreateQueryFor(ancestor,filter);
            return Member.Query1(query);
        }
        else
            throw new IllegalStateException("Missing ancestor key.");
    }
    public Iterable<Member> list(Filter filter, Page page){
        Key ancestor = this.ancestorKey;
        if (null != ancestor){
            Query query = Member.CreateQueryFor(ancestor,filter);
            return Member.QueryN(query,page);
        }
        else
            throw new IllegalStateException("Missing ancestor key.");
    }
    public List.Short<Member> clone(){
        List list = super.clone();
        return (List.Short<Member>)list;
    }
    public List.Short<Member> add(Member item){
        super.add(item);
        return this;
    }
    /**
     * @see gap.data.List$Short#nhead(int)
     */
    public Iterable<Member> nhead(int count){
        final BigTable[] buffer = this.buffer;
        if (null != buffer){
            final int size = this.gross;
            if (0 > count){
                return (Iterable<Member>)(new BufferIterator());
            }
            else if (size == buffer.length || count < buffer.length){
                if (count < size){
                    Member[] re = (Member[])(new BigTable[count]);
                    System.arraycopy(buffer,0,re,0,count);
                    return (Iterable<Member>)(new BufferIterator(re));
                }
                else
                    return (Iterable<Member>)(new BufferIterator(buffer));
            }
            else {
                Query q = new Query(Member.KIND.getName(),this.ancestorKey).addSort(Member.DefaultSortBy,Query.SortDirection.ASCENDING);
                Page p = new Page(0,count);
                return Store.QueryNClass(q,p);
            }
        }
        else
            return (Iterable<Member>)(new BufferIterator());
    }
    /**
     * @see gap.data.List$Short#ntail(int)
     */
    public Iterable<Member> ntail(int count){
        final BigTable[] buffer = this.buffer;
        if (null != buffer){
            final int size = this.gross;
            if (0 > count){
                return (Iterable<Member>)(new BufferIterator());
            }
            else if (size == buffer.length){
                if (count < size){
                    final int x = (size-count-1);
                    if (x < buffer.length){
                        Member[] re = (Member[])(new BigTable[count]);
                        System.arraycopy(buffer,x,re,0,count);
                        return (Iterable<Member>)(new BufferIterator(re));
                    }
                    else
                        return (Iterable<Member>)(new BufferIterator());
                }
                else
                    return (Iterable<Member>)(new BufferIterator(buffer));
            }
            else {
                Query q = new Query(Member.KIND.getName(),this.ancestorKey).addSort(Member.DefaultSortBy,Query.SortDirection.DESCENDING);
                Page p = new Page(0,count);
                return Store.QueryNClass(q,p);
            }
        }
        else
            return (Iterable<Member>)(new BufferIterator());
    }

}
