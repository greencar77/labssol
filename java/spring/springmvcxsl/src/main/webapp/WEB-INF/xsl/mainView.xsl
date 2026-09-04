<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Spring MVC + XSL Example</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 40px; }
                    .form-container { border: 1px solid #ccc; padding: 20px; margin-bottom: 20px; border-radius: 5px; }
                    .message { color: blue; font-weight: bold; margin-bottom: 20px; }
                    h2 { color: #333; }
                    .btn-disabled { background-color: #ccc; cursor: not-allowed; }
                </style>
            </head>
            <body>
                <h1>Spring MVC + XSL + Axis Demo</h1>

                <xsl:if test="userData/message">
                    <div class="message">
                        <xsl:value-of select="userData/message"/>
                    </div>
                </xsl:if>

                <div class="form-container">
                    <h2>Form 1: Configuration</h2>
                    <form action="process" method="post">
                        <p>Clicking "Disable Form 2" will set a condition to disable the submit button in the next form.</p>
                        <input type="hidden" name="action" value="disable"/>
                        <input type="submit" value="Disable Form 2 Button"/>
                    </form>
                    <form action="process" method="post" style="margin-top: 10px;">
                        <input type="hidden" name="action" value="enable"/>
                        <input type="submit" value="Reset / Enable Form 2 Button"/>
                    </form>
                </div>

                <div class="form-container">
                    <h2>Form 2: Data Input</h2>
                    <form action="process" method="post">
                        <div>
                            <label>Name: </label>
                            <input type="text" name="name">
                                <xsl:attribute name="value">
                                    <xsl:value-of select="userData/name"/>
                                </xsl:attribute>
                            </input>
                        </div>
                        <div style="margin-top: 10px;">
                            <label>Email: </label>
                            <input type="text" name="email">
                                <xsl:attribute name="value">
                                    <xsl:value-of select="userData/email"/>
                                </xsl:attribute>
                            </input>
                        </div>
                        <div style="margin-top: 20px;">
                            <input type="submit" value="Submit Data">
                                <xsl:if test="userData/disableSubmit = 'true'">
                                    <xsl:attribute name="disabled">disabled</xsl:attribute>
                                    <xsl:attribute name="class">btn-disabled</xsl:attribute>
                                    <xsl:attribute name="title">Button is disabled by Form 1 condition</xsl:attribute>
                                </xsl:if>
                            </input>
                        </div>
                    </form>
                </div>

                <hr/>
                <div style="font-size: 0.8em; color: #666;">
                    <p>Note: Axis 1 components are configured in web.xml but this demo primarily shows the MVC + XSL integration.</p>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
