"use strict";

var helpers = require("../../helpers/helpers");

exports["US/Aleutian"] = {
	"1942" : helpers.makeTestYear("US/Aleutian", [
		["1942-02-09T12:59:59+00:00", "01:59:59", "NST", 660],
		["1942-02-09T13:00:00+00:00", "03:00:00", "NWT", 600]
	]),

	"1945" : helpers.makeTestYear("US/Aleutian", [
		["1945-08-14T22:59:59+00:00", "12:59:59", "NWT", 600],
		["1945-08-14T23:00:00+00:00", "13:00:00", "NPT", 600],
		["1945-09-30T11:59:59+00:00", "01:59:59", "NPT", 600],
		["1945-09-30T12:00:00+00:00", "01:00:00", "NST", 660]
	]),

	"1967" : helpers.makeTestYear("US/Aleutian", [
		["1967-04-01T10:59:59+00:00", "23:59:59", "NST", 660],
		["1967-04-01T11:00:00+00:00", "00:00:00", "BST", 660]
	]),

	"1969" : helpers.makeTestYear("US/Aleutian", [
		["1969-04-27T12:59:59+00:00", "01:59:59", "BST", 660],
		["1969-04-27T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1969-10-26T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1969-10-26T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1970" : helpers.makeTestYear("US/Aleutian", [
		["1970-04-26T12:59:59+00:00", "01:59:59", "BST", 660],
		["1970-04-26T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1970-10-25T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1970-10-25T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1971" : helpers.makeTestYear("US/Aleutian", [
		["1971-04-25T12:59:59+00:00", "01:59:59", "BST", 660],
		["1971-04-25T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1971-10-31T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1971-10-31T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1972" : helpers.makeTestYear("US/Aleutian", [
		["1972-04-30T12:59:59+00:00", "01:59:59", "BST", 660],
		["1972-04-30T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1972-10-29T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1972-10-29T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1973" : helpers.makeTestYear("US/Aleutian", [
		["1973-04-29T12:59:59+00:00", "01:59:59", "BST", 660],
		["1973-04-29T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1973-10-28T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1973-10-28T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1974" : helpers.makeTestYear("US/Aleutian", [
		["1974-01-06T12:59:59+00:00", "01:59:59", "BST", 660],
		["1974-01-06T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1974-10-27T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1974-10-27T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1975" : helpers.makeTestYear("US/Aleutian", [
		["1975-02-23T12:59:59+00:00", "01:59:59", "BST", 660],
		["1975-02-23T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1975-10-26T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1975-10-26T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1976" : helpers.makeTestYear("US/Aleutian", [
		["1976-04-25T12:59:59+00:00", "01:59:59", "BST", 660],
		["1976-04-25T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1976-10-31T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1976-10-31T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1977" : helpers.makeTestYear("US/Aleutian", [
		["1977-04-24T12:59:59+00:00", "01:59:59", "BST", 660],
		["1977-04-24T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1977-10-30T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1977-10-30T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1978" : helpers.makeTestYear("US/Aleutian", [
		["1978-04-30T12:59:59+00:00", "01:59:59", "BST", 660],
		["1978-04-30T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1978-10-29T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1978-10-29T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1979" : helpers.makeTestYear("US/Aleutian", [
		["1979-04-29T12:59:59+00:00", "01:59:59", "BST", 660],
		["1979-04-29T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1979-10-28T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1979-10-28T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1980" : helpers.makeTestYear("US/Aleutian", [
		["1980-04-27T12:59:59+00:00", "01:59:59", "BST", 660],
		["1980-04-27T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1980-10-26T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1980-10-26T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1981" : helpers.makeTestYear("US/Aleutian", [
		["1981-04-26T12:59:59+00:00", "01:59:59", "BST", 660],
		["1981-04-26T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1981-10-25T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1981-10-25T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1982" : helpers.makeTestYear("US/Aleutian", [
		["1982-04-25T12:59:59+00:00", "01:59:59", "BST", 660],
		["1982-04-25T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1982-10-31T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1982-10-31T12:00:00+00:00", "01:00:00", "BST", 660]
	]),

	"1983" : helpers.makeTestYear("US/Aleutian", [
		["1983-04-24T12:59:59+00:00", "01:59:59", "BST", 660],
		["1983-04-24T13:00:00+00:00", "03:00:00", "BDT", 600],
		["1983-10-30T11:59:59+00:00", "01:59:59", "BDT", 600],
		["1983-10-30T12:00:00+00:00", "02:00:00", "AHST", 600],
		["1983-11-30T09:59:59+00:00", "23:59:59", "AHST", 600],
		["1983-11-30T10:00:00+00:00", "00:00:00", "HAST", 600]
	]),

	"1984" : helpers.makeTestYear("US/Aleutian", [
		["1984-04-29T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1984-04-29T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1984-10-28T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1984-10-28T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1985" : helpers.makeTestYear("US/Aleutian", [
		["1985-04-28T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1985-04-28T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1985-10-27T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1985-10-27T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1986" : helpers.makeTestYear("US/Aleutian", [
		["1986-04-27T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1986-04-27T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1986-10-26T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1986-10-26T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1987" : helpers.makeTestYear("US/Aleutian", [
		["1987-04-05T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1987-04-05T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1987-10-25T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1987-10-25T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1988" : helpers.makeTestYear("US/Aleutian", [
		["1988-04-03T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1988-04-03T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1988-10-30T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1988-10-30T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1989" : helpers.makeTestYear("US/Aleutian", [
		["1989-04-02T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1989-04-02T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1989-10-29T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1989-10-29T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1990" : helpers.makeTestYear("US/Aleutian", [
		["1990-04-01T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1990-04-01T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1990-10-28T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1990-10-28T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1991" : helpers.makeTestYear("US/Aleutian", [
		["1991-04-07T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1991-04-07T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1991-10-27T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1991-10-27T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1992" : helpers.makeTestYear("US/Aleutian", [
		["1992-04-05T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1992-04-05T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1992-10-25T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1992-10-25T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1993" : helpers.makeTestYear("US/Aleutian", [
		["1993-04-04T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1993-04-04T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1993-10-31T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1993-10-31T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1994" : helpers.makeTestYear("US/Aleutian", [
		["1994-04-03T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1994-04-03T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1994-10-30T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1994-10-30T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1995" : helpers.makeTestYear("US/Aleutian", [
		["1995-04-02T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1995-04-02T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1995-10-29T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1995-10-29T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1996" : helpers.makeTestYear("US/Aleutian", [
		["1996-04-07T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1996-04-07T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1996-10-27T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1996-10-27T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1997" : helpers.makeTestYear("US/Aleutian", [
		["1997-04-06T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1997-04-06T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1997-10-26T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1997-10-26T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1998" : helpers.makeTestYear("US/Aleutian", [
		["1998-04-05T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1998-04-05T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1998-10-25T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1998-10-25T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"1999" : helpers.makeTestYear("US/Aleutian", [
		["1999-04-04T11:59:59+00:00", "01:59:59", "HAST", 600],
		["1999-04-04T12:00:00+00:00", "03:00:00", "HADT", 540],
		["1999-10-31T10:59:59+00:00", "01:59:59", "HADT", 540],
		["1999-10-31T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2000" : helpers.makeTestYear("US/Aleutian", [
		["2000-04-02T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2000-04-02T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2000-10-29T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2000-10-29T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2001" : helpers.makeTestYear("US/Aleutian", [
		["2001-04-01T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2001-04-01T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2001-10-28T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2001-10-28T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2002" : helpers.makeTestYear("US/Aleutian", [
		["2002-04-07T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2002-04-07T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2002-10-27T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2002-10-27T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2003" : helpers.makeTestYear("US/Aleutian", [
		["2003-04-06T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2003-04-06T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2003-10-26T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2003-10-26T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2004" : helpers.makeTestYear("US/Aleutian", [
		["2004-04-04T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2004-04-04T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2004-10-31T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2004-10-31T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2005" : helpers.makeTestYear("US/Aleutian", [
		["2005-04-03T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2005-04-03T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2005-10-30T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2005-10-30T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2006" : helpers.makeTestYear("US/Aleutian", [
		["2006-04-02T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2006-04-02T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2006-10-29T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2006-10-29T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2007" : helpers.makeTestYear("US/Aleutian", [
		["2007-03-11T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2007-03-11T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2007-11-04T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2007-11-04T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2008" : helpers.makeTestYear("US/Aleutian", [
		["2008-03-09T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2008-03-09T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2008-11-02T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2008-11-02T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2009" : helpers.makeTestYear("US/Aleutian", [
		["2009-03-08T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2009-03-08T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2009-11-01T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2009-11-01T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2010" : helpers.makeTestYear("US/Aleutian", [
		["2010-03-14T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2010-03-14T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2010-11-07T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2010-11-07T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2011" : helpers.makeTestYear("US/Aleutian", [
		["2011-03-13T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2011-03-13T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2011-11-06T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2011-11-06T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2012" : helpers.makeTestYear("US/Aleutian", [
		["2012-03-11T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2012-03-11T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2012-11-04T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2012-11-04T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2013" : helpers.makeTestYear("US/Aleutian", [
		["2013-03-10T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2013-03-10T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2013-11-03T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2013-11-03T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2014" : helpers.makeTestYear("US/Aleutian", [
		["2014-03-09T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2014-03-09T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2014-11-02T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2014-11-02T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2015" : helpers.makeTestYear("US/Aleutian", [
		["2015-03-08T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2015-03-08T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2015-11-01T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2015-11-01T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2016" : helpers.makeTestYear("US/Aleutian", [
		["2016-03-13T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2016-03-13T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2016-11-06T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2016-11-06T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2017" : helpers.makeTestYear("US/Aleutian", [
		["2017-03-12T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2017-03-12T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2017-11-05T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2017-11-05T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2018" : helpers.makeTestYear("US/Aleutian", [
		["2018-03-11T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2018-03-11T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2018-11-04T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2018-11-04T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2019" : helpers.makeTestYear("US/Aleutian", [
		["2019-03-10T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2019-03-10T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2019-11-03T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2019-11-03T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2020" : helpers.makeTestYear("US/Aleutian", [
		["2020-03-08T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2020-03-08T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2020-11-01T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2020-11-01T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2021" : helpers.makeTestYear("US/Aleutian", [
		["2021-03-14T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2021-03-14T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2021-11-07T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2021-11-07T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2022" : helpers.makeTestYear("US/Aleutian", [
		["2022-03-13T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2022-03-13T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2022-11-06T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2022-11-06T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2023" : helpers.makeTestYear("US/Aleutian", [
		["2023-03-12T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2023-03-12T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2023-11-05T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2023-11-05T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2024" : helpers.makeTestYear("US/Aleutian", [
		["2024-03-10T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2024-03-10T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2024-11-03T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2024-11-03T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2025" : helpers.makeTestYear("US/Aleutian", [
		["2025-03-09T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2025-03-09T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2025-11-02T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2025-11-02T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2026" : helpers.makeTestYear("US/Aleutian", [
		["2026-03-08T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2026-03-08T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2026-11-01T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2026-11-01T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2027" : helpers.makeTestYear("US/Aleutian", [
		["2027-03-14T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2027-03-14T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2027-11-07T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2027-11-07T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2028" : helpers.makeTestYear("US/Aleutian", [
		["2028-03-12T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2028-03-12T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2028-11-05T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2028-11-05T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2029" : helpers.makeTestYear("US/Aleutian", [
		["2029-03-11T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2029-03-11T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2029-11-04T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2029-11-04T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2030" : helpers.makeTestYear("US/Aleutian", [
		["2030-03-10T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2030-03-10T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2030-11-03T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2030-11-03T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2031" : helpers.makeTestYear("US/Aleutian", [
		["2031-03-09T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2031-03-09T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2031-11-02T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2031-11-02T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2032" : helpers.makeTestYear("US/Aleutian", [
		["2032-03-14T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2032-03-14T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2032-11-07T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2032-11-07T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2033" : helpers.makeTestYear("US/Aleutian", [
		["2033-03-13T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2033-03-13T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2033-11-06T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2033-11-06T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2034" : helpers.makeTestYear("US/Aleutian", [
		["2034-03-12T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2034-03-12T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2034-11-05T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2034-11-05T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2035" : helpers.makeTestYear("US/Aleutian", [
		["2035-03-11T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2035-03-11T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2035-11-04T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2035-11-04T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2036" : helpers.makeTestYear("US/Aleutian", [
		["2036-03-09T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2036-03-09T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2036-11-02T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2036-11-02T11:00:00+00:00", "01:00:00", "HAST", 600]
	]),

	"2037" : helpers.makeTestYear("US/Aleutian", [
		["2037-03-08T11:59:59+00:00", "01:59:59", "HAST", 600],
		["2037-03-08T12:00:00+00:00", "03:00:00", "HADT", 540],
		["2037-11-01T10:59:59+00:00", "01:59:59", "HADT", 540],
		["2037-11-01T11:00:00+00:00", "01:00:00", "HAST", 600]
	])
};