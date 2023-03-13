<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>

    <!-- Определяем шаблон для корневого элемента -->
    <xsl:template match="/">
        <origin>
            <!-- Применяем шаблон для всех xml_power_tool элементов -->
            <xsl:apply-templates select="//power_tool"/>
        </origin>
    </xsl:template>

    <!-- Определяем шаблон для xml_power_tool элемента -->
    <xsl:template match="power_tool">
        <power_tool>
            <model><xsl:value-of select="model"/></model>
            <handy><xsl:value-of select="handy"/></handy>
            <tc>
                <power_consumption><xsl:value-of select="tc/power_consumption"/></power_consumption>
                <productivity><xsl:value-of select="tc/productivity"/></productivity>
                <autonomy><xsl:value-of select="tc/autonomy"/></autonomy>
                </tc>
            <material><xsl:value-of select="material"/></material>
        </power_tool>
    </xsl:template>
</xsl:stylesheet>